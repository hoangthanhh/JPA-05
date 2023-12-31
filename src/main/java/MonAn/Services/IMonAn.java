package MonAn.Services;

import MonAn.Models.MonAn;

import java.util.List;

public interface IMonAn {
    public MonAn themMonAn(MonAn monAn);
    public List<MonAn> timKiemMonAn(String tenMon, String tenNguyenLieu);
}
