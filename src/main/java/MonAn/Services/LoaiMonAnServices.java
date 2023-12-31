package MonAn.Services;

import MonAn.Models.LoaiMonAn;
import MonAn.repository.CongThucRepo;
import MonAn.repository.LoaiMonAnRepo;
import MonAn.repository.MonAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiMonAnServices implements ILoaiMonAn {
    @Autowired
    private LoaiMonAnRepo loaiMonAnRepo;
    @Autowired
    private MonAnRepo monAnRepo;
    @Autowired
    private CongThucRepo congThucRepo;

    @Override
    public String xoa1LoaiMon(int loaiMonAnId) {
        monAnRepo.findAll().forEach(x->{
            if (x.getLoaiMonAn().getLoaiMonAnId() == loaiMonAnId) {
                congThucRepo.findAll().forEach(y->{
                    if (y.getMonAn() == x) {
                        congThucRepo.delete(y);
                    }
                });
                monAnRepo.delete(x);
            }
        });
        loaiMonAnRepo.deleteById(loaiMonAnId);
        return "Xoa thanh cong";
    }
}
