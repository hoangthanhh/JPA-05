package MonAn.repository;

import MonAn.Models.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonAnRepo extends JpaRepository<MonAn,Integer> {
    @Query(value = "SELECT monan.* \n" +
            "FROM monan \n" +
            "RIGHT JOIN congthuc ON monan.mon_an_id = congthuc.mon_an_id \n" +
            "RIGHT JOIN nguyenlieu ON congthuc.nguyen_lieu_id = nguyenlieu.nguyen_lieu_id \n" +
            "WHERE monan.tenmon LIKE %:tenMon% AND nguyenlieu.tennguyenlieu LIKE %:tenNguyenLieu%", nativeQuery = true)
    List<MonAn> timKiemMonAn(@Param("tenNguyenLieu") String tenNguyenLieu, @Param("tenMon") String tenMon);

//    @Query(value = "select mon_an_id from monan")
//    List<Integer> ids();
}
