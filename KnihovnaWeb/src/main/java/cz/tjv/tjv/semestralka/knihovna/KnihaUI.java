package cz.tjv.tjv.semestralka.knihovna;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.ValueProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.EditorSaveEvent;
import com.vaadin.ui.components.grid.EditorSaveListener;
import cz.tjv.tjv.semestralka.knihovnaweb.rest.AutorClient;
import cz.tjv.tjv.semestralka.knihovnaweb.rest.KnihaClient;
import cz.tjv.tjv.semestralka.knihovnaweb.rest.VydavatelClient;
import cz.tjv.tjv.semestralkadto.AutorDTO;
import cz.tjv.tjv.semestralkadto.KnihaDTO;
import cz.tjv.tjv.semestralkadto.VydavatelDTO;
import java.util.Optional;

@Theme("mytheme")
public class KnihaUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        KnihaClient knihaClient = new KnihaClient();
        AutorClient autorClient = new AutorClient();
        VydavatelClient vydavatelClient = new VydavatelClient();
        
        Grid<KnihaDTO> knihaGrid = new Grid<>();
        Grid<AutorDTO> autorGrid = new Grid<>();
        Grid<VydavatelDTO> vydavatelGrid = new Grid<>();
        
        Label knihaHeader = new Label("Knihy");
        knihaGrid.getEditor().setEnabled(true);
        knihaGrid.getEditor().addSaveListener(new EditorSaveListener<KnihaDTO>(){
            @Override
            public void onEditorSave(EditorSaveEvent<KnihaDTO> event) {
                knihaClient.createOrUpdate(event.getBean());
            }
        });
        
        knihaGrid.addColumn(KnihaDTO::getId).setCaption("ID");
        knihaGrid.addColumn(KnihaDTO::getName).setEditorComponent(new TextField(), KnihaDTO::setName).setEditable(true).setCaption("Kniha");
        knihaGrid.addColumn(new ValueProvider<KnihaDTO, String>(){
            @Override
            public String apply(KnihaDTO source) {
                return source.getAutor().getName();
            }
        }).setCaption("Autor");
        knihaGrid.addColumn(new ValueProvider<KnihaDTO, String>(){
            @Override
            public String apply(KnihaDTO source) {
                return source.getVydavatel().getName();
            }
        }).setCaption("Vydavatel");
        knihaGrid.addComponentColumn(new ValueProvider<KnihaDTO, Button>(){
            @Override
            public Button apply(KnihaDTO source) {
                Button b = new Button("Smazat");
                b.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        knihaClient.delete(source.getId());
                        knihaGrid.setItems(knihaClient.selectAll());
                    }
                });
                return b;
            }
        });
        
        knihaGrid.setItems(knihaClient.selectAll());
        
        TextField knihaName = new TextField("Název");
        Button submitNewKniha = new Button("Přidat knihu");
        submitNewKniha.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Optional<AutorDTO> aOpt = autorGrid.getSelectionModel().getFirstSelectedItem();
                Optional<VydavatelDTO> vOpt = vydavatelGrid.getSelectionModel().getFirstSelectedItem();

                if (aOpt.isPresent() && vOpt.isPresent()) {
                    KnihaDTO k = new KnihaDTO();
                    k.setName(knihaName.getValue());
                    k.setAutor(aOpt.get());
                    k.setVydavatel(vOpt.get());
                    knihaClient.createOrUpdate(k);
                    knihaGrid.setItems(knihaClient.selectAll());
                }
            }
        });
        
        
        Label autorHeader = new Label("Autoři");
        autorGrid.getEditor().setEnabled(true);
        autorGrid.getEditor().addSaveListener(new EditorSaveListener<AutorDTO>() {
            @Override
            public void onEditorSave(EditorSaveEvent<AutorDTO> event) {
                autorClient.createOrUpdate(event.getBean());
                knihaGrid.setItems(knihaClient.selectAll());
            }
        });
        
        autorGrid.addColumn(AutorDTO::getId).setCaption("ID");
        autorGrid.addColumn(AutorDTO::getName).setEditorComponent(new TextField(), AutorDTO::setName).setEditable(true).setCaption("Autor");
        autorGrid.addComponentColumn(new ValueProvider<AutorDTO, Button>(){
            @Override
            public Button apply(AutorDTO source) {
                Button b = new Button("Smazat");
                b.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        autorClient.delete(source.getId());
                        autorGrid.setItems(autorClient.selectAll());
                    }
                });
                return b;
            }
        });
        
        autorGrid.setItems(autorClient.selectAll());
               
        TextField autorName = new TextField("Jméno");
        Button submitNewAutor = new Button("Přidat autora");
        submitNewAutor.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                AutorDTO a = new AutorDTO();
                a.setName(autorName.getValue());
                autorClient.createOrUpdate(a);
                autorGrid.setItems(autorClient.selectAll());
            }
        });
        
        
        Label vydavatelHeader = new Label("Vydavatelé");
        vydavatelGrid.getEditor().setEnabled(true);
        vydavatelGrid.getEditor().addSaveListener(new EditorSaveListener<VydavatelDTO>() {
            @Override
            public void onEditorSave(EditorSaveEvent<VydavatelDTO> event) {
                vydavatelClient.createOrUpdate(event.getBean());
                knihaGrid.setItems(knihaClient.selectAll());
            }
        });
        
        vydavatelGrid.addColumn(VydavatelDTO::getId).setCaption("ID");
        vydavatelGrid.addColumn(VydavatelDTO::getName).setEditorComponent(new TextField(), VydavatelDTO::setName).setEditable(true).setCaption("Vydavatel");
        vydavatelGrid.addComponentColumn(new ValueProvider<VydavatelDTO, Button>(){
            @Override
            public Button apply(VydavatelDTO source) {
                Button b = new Button("Smazat");
                b.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        vydavatelClient.delete(source.getId());
                        vydavatelGrid.setItems(vydavatelClient.selectAll());
                    }
                });
                return b;
            }
        });
        
        vydavatelGrid.setItems(vydavatelClient.selectAll());
               
        TextField vydavatelName = new TextField("Jméno");
        Button submitNewVydavatel = new Button("Přidat vydavatele");
        submitNewVydavatel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                VydavatelDTO v = new VydavatelDTO();
                v.setName(vydavatelName.getValue());
                vydavatelClient.createOrUpdate(v);
                vydavatelGrid.setItems(vydavatelClient.selectAll());
            }
        });
        
        layout.addComponents(knihaHeader, knihaName, submitNewKniha, knihaGrid);
        layout.addComponents(autorHeader, autorName, submitNewAutor, autorGrid);
        layout.addComponents(vydavatelHeader, vydavatelName, submitNewVydavatel, vydavatelGrid);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = KnihaUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
