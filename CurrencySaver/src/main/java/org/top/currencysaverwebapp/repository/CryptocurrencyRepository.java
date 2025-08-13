package org.top.currencysaverwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.top.currencysaverwebapp.entity.Cryptocurrency;

import java.util.List;
import java.util.Optional;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, String> {
    //Черная магия
    List<Cryptocurrency> findTop100ByOrderByMarketCapRankAsc();
    Optional<Cryptocurrency> findFirstByNameOrderByLastUpdatedStringDesc(String name);
    Optional<Cryptocurrency> findByName(String name);
}
