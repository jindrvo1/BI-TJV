package cz.tjv.tjv.semestralka.entity;

import cz.tjv.tjv.semestralka.entity.Kniha;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-04T01:09:01")
@StaticMetamodel(Vydavatel.class)
public class Vydavatel_ { 

    public static volatile ListAttribute<Vydavatel, Kniha> knihy;
    public static volatile SingularAttribute<Vydavatel, String> name;
    public static volatile SingularAttribute<Vydavatel, Long> id;

}