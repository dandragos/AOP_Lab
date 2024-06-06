package test2.pr2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){


        List<Asigurare> asigurari = new ArrayList<>();

        asigurari.add(new Asigurare("RCA", "ASC ASIG", 400, "Bucuresti"));
        asigurari.add(new Asigurare("RBA", "BCD ASIG", 400, "Ploiesti"));
        asigurari.add(new Asigurare("RCA", "EFG ASIG", 400, "Resita"));
        asigurari.add(new Asigurare("RDA", "BCD ASIG", 12500, "Bucuresti"));
        asigurari.add(new Asigurare("RDA", "BCD ASIG", 49000, "Bucuresti"));

        asigurari.stream()
                .filter(a -> a.getTip().equalsIgnoreCase("RCA"))
                .forEach(System.out :: println);

        asigurari.stream()
                .map(Asigurare :: getLocalitate)
                .distinct()
                .forEach(System.out :: println);

        Collection <Asigurare> AsigurariInBuc = asigurari.stream()
                .filter(a -> a.getLocalitate().equalsIgnoreCase("Bucuresti"))
                .filter(v -> v.getValoare() >= 10000 && v.getValoare() <= 50000)
                .toList();

        System.out.println(AsigurariInBuc);

        Map<String,List<Asigurare>> TitularAsig = asigurari.stream()
                .collect(Collectors.groupingBy( Asigurare :: getTitular));

        TitularAsig.forEach((titular,listaAsigurari) -> {
            System.out.println("Titular: " + titular);
            listaAsigurari.forEach(asigurare -> System.out.println(asigurare));
            System.out.println();
        });










    }
}
