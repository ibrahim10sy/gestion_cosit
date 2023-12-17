package gestion.cosit.gestionDepense.repository;

import gestion.cosit.gestionDepense.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {

    Budget findByIdBudget(long id);

//    Budget findByDateFin(LocalDate localDate);
    Budget findByDateFin(LocalDate dateFin);
    List<Budget> findByDescriptionContaining( String desc);

    @Query(value = "SELECT * FROM Budget WHERE  date_debut LIKE :date ",nativeQuery = true)
    List<Budget> getBudgetByMonthAndYear(@Param("date") String date);

    @Query(value = "SELECT sum(montant), sum(montant_restant) FROM Budget", nativeQuery = true)
    Double[][] getSommeOfTotalBudgetNotFinish();

}
