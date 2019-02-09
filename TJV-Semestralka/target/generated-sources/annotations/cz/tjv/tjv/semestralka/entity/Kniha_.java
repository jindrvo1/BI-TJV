package cz.tjv.tjv.semestralka.entity;

import cz.tjv.tjv.semestralka.entity.Autor;
import cz.tjv.tjv.semestralka.entity.Vydavatel;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-04T01:09:01")
@StaticMetamodel(Kniha.class)
public class Kniha_ { 

    public static volatile SingularAttribute<Kniha, String> name;
    public static volatile SingularAttribute<Kniha, Long> id;
    public static volatile SingularAttribute<Kniha, Vydavatel> vydavatel;
    public static volatile SingularAttribute<Kniha, Autor> autor;

}