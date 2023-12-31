package MonAn.Controller;

import MonAn.Services.LoaiMonAnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoaiMonAnController {
    @Autowired
    private LoaiMonAnServices loaiMonAnServices;

    @RequestMapping(value = "xoa1loaimon", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoa1LoaiMon(@RequestParam int loaiMonAnId){
        return loaiMonAnServices.xoa1LoaiMon(loaiMonAnId);
    }
}
