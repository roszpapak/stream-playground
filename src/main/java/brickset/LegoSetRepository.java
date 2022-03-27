package brickset;

import repository.Repository;

import java.util.Comparator;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }


    public void PrintAllLegoName(){
        var repository = new LegoSetRepository();
        repository.getAll().stream()
                .map(LegoSet::getName)
                .forEach(System.out::println);

    }


    /**
     * Kiirja a 10 legtöbb elemmel rendelkező elem nevét.
     */

    public void PrintFirst10WithMostPieces(){
        var repository = new LegoSetRepository();
        var legos = repository.getAll();
        legos.stream()
                .sorted(Comparator.comparing(LegoSet::getPieces).reversed())
                .limit(10)
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     * Kiirja a Dimensionnal rendelkező elemeket.
     */
    public void PrintWhereDimensionsIsNotNull(){
        var repository = new LegoSetRepository();
        var legos = repository.getAll();
        legos.stream()
                .filter(legoSet -> legoSet.getDimensions() != null)
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }


    /**
     * Kiirja azon elemeket melyeknek darabszáma nulla
     */
    public void PrintNameWith0Pieces(){
        var repository = new LegoSetRepository();
        var legos = repository.getAll();
        legos.stream()
                .filter(legoSet -> legoSet.getPieces() == 0)
                .distinct()
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     * Kiirja azon elemek nevét melyeknek a neve hosszabb mint a number
     *
     *
     * @param number nev hossza
     */

    public void PrintNamesLongerThan(int number){
        var repository = new LegoSetRepository();
        var legos = repository.getAll();
        legos.stream()
                .map(LegoSet::getName)
                .filter(s -> s.length() > number)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        var repositoy = new LegoSetRepository();

        repositoy.PrintAllLegoName();
        repositoy.PrintFirst10WithMostPieces();
        repositoy.PrintNameWith0Pieces();
        repositoy.PrintWhereDimensionsIsNotNull();
        repositoy.PrintNamesLongerThan(30);
    }

}
