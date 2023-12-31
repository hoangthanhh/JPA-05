package MonAn.Services;

import MonAn.Models.LoaiMonAn;
import MonAn.Models.MonAn;
import MonAn.repository.LoaiMonAnRepo;
import MonAn.repository.MonAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonAnServices implements IMonAn {
    @Autowired
    private LoaiMonAnRepo loaiMonAnRepo;
    @Autowired
    private MonAnRepo monAnRepo;
    @Override
    public MonAn themMonAn(MonAn monAn) {
        Optional<LoaiMonAn> loaiMonAn = loaiMonAnRepo.findById(monAn.getLoaiMonAn().getLoaiMonAnId());
        if (loaiMonAn.isEmpty()) {
            return null;
        }
        monAnRepo.save(monAn);
        return monAn;
    }

    @Override
    public List<MonAn> timKiemMonAn(String tenMon, String tenNguyenLieu) {
        List<MonAn> list = monAnRepo.timKiemMonAn(tenMon,tenNguyenLieu);
        return list;
    }
}
