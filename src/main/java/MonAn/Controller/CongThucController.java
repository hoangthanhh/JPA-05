package MonAn.Controller;

import MonAn.Models.CongThuc;
import MonAn.Services.CongThucServices;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CongThucController {
    @Autowired
    private CongThucServices congThucServices;

    @RequestMapping(value = "themcaccongthuc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String themCacCongThuc(@RequestBody List<CongThuc> list, @RequestParam int monAnId) {
        return congThucServices.themCacCongThuc(list, monAnId);
    }


    @GetMapping("/findAlls")
    ResponseEntity<?> findAlls(){
        return ResponseEntity.ok(congThucServices.getCongThucRepo().findAlls());
    }
}
