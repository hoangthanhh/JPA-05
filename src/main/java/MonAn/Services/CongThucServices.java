package MonAn.Services;

import MonAn.Models.CongThuc;
import MonAn.Models.MonAn;
import MonAn.Models.NguyenLieu;
import MonAn.repository.CongThucRepo;
import MonAn.repository.MonAnRepo;
import MonAn.repository.NguyenLieuRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongThucServices implements ICongThuc {
    @Autowired
    private MonAnRepo monAnRepo;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    private CongThucRepo congThucRepo;

    @Override
    public String themCacCongThuc(List<CongThuc> list, int monAnId) {
        MonAn monAn = monAnRepo.findById(monAnId).orElseThrow(() ->new EntityNotFoundException("Khong tim thay mon an voi Id:" + monAnId));

        for (CongThuc congThuc: list) {
            if (monAnId == congThuc.getMonAn().getMonAnId()) {
                monAn.setCachLam(monAn.getCachLam() + "\n" +
                        nguyenLieuRepo.findById(congThuc.getNguyenLieu().getNguyenLieuId()).get().getTenNguyenLieu() + " : " +
                        String.valueOf(congThuc.getSoLuong()) + " " + congThuc.getDonViTinh() + ", ");
                monAnRepo.save(monAn);
                congThucRepo.save(congThuc);
            }
            else {
                return "Chi tiet nay khong thoa man";
            }
        }
        return "Them thanh cong";
    }
}
