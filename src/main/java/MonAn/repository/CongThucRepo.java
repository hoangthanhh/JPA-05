package MonAn.repository;

import MonAn.Models.CongThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongThucRepo extends JpaRepository<CongThuc,Integer> {

    @Query(value = "select * from congthuc", nativeQuery = true)
    List<CongThuc> findAlls();
}
