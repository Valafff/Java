package org.top.currencysaverwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.top.currencysaverwebapp.entity.Cryptocurrency;

import java.util.List;
import java.util.Optional;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, String> {
    //Черная магия
   List<Cryptocurrency> findTop100ByOrderByMarketCapRankAsc();

//    List<Cryptocurrency> findDistinctTop100LatestByMarketCapRank();
    Optional<Cryptocurrency> findFirstByNameOrderByLastUpdatedStringDesc(String name);
    Optional<Cryptocurrency> findByName(String name);

    @Query("SELECT c FROM Cryptocurrency c WHERE c.lastUpdatedString = " +
            "(SELECT MAX(cc.lastUpdatedString) FROM Cryptocurrency cc WHERE cc.name = c.name)")
    List<Cryptocurrency> findLatestDistinctCurrencies();
}
