package MonAn.Controller;

import MonAn.Models.MonAn;
import MonAn.Services.MonAnServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class MonAnController {
    @Autowired
    private MonAnServices monAnServices;

    @RequestMapping(value = "themmonan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MonAn themNguyenLieu(@RequestBody String monAn) {
        Gson gson = new Gson();
        MonAn mon = gson.fromJson(monAn, MonAn.class);
        return monAnServices.themMonAn(mon);
    }

    @RequestMapping(value = "timkiemmonan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonAn> timKiemMonAn(@RequestParam String tenMon, @RequestParam String tenNguyenLieu) {
        return monAnServices.timKiemMonAn(tenMon,tenNguyenLieu);
    }
}
