package com.codegym.thuchanhmodule4.Controller;

import com.codegym.thuchanhmodule4.Dto.GiaoDichDTO;
import com.codegym.thuchanhmodule4.Service.GiaoDichService;
import com.codegym.thuchanhmodule4.Service.khachHangService;
import com.codegym.thuchanhmodule4.model.GiaoDich;
import com.codegym.thuchanhmodule4.model.KhachHang;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/gd")
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;

    @Autowired
    private khachHangService khachHangService;

    @GetMapping
    public String listGiaoDich(Model model) {
        model.addAttribute("giaoDichList", giaoDichService.getAllGiaoDich());
        return "/list";
    }

//    @GetMapping("/them-moi")
//    public String showAddForm(Model model) {
//        GiaoDich giaoDich = new GiaoDich();
//        List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
//        model.addAttribute("giaoDich", giaoDich);
//        model.addAttribute("khachHangList", khachHangList);
//        return "/add";
//    }
@GetMapping("/them-moi")
public String showAddForm(Model model) {
    GiaoDichDTO giaoDichDTO = new GiaoDichDTO();
    List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
    model.addAttribute("giaoDich", giaoDichDTO);
    model.addAttribute("khachHangList", khachHangList);
    return "/add";
}

    @PostMapping("/them-moi")
    public String addGiaoDich(@Valid @ModelAttribute("giaoDich") GiaoDichDTO giaoDichDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
            model.addAttribute("khachHangList", khachHangList);
            return "/add";
        }

        GiaoDich giaoDich = new GiaoDich();
        giaoDich.setMaGiaoDich(giaoDichDTO.getMaGiaoDich());
        giaoDich.setKhachHang(khachHangService.getKhachHangById(giaoDichDTO.getMaKhachHang()));
        giaoDich.setLoaiDichVu(giaoDichDTO.getLoaiDichVu());
        giaoDich.setNgayGiaoDich(giaoDichDTO.getNgayGiaoDich());
        giaoDich.setDonGia(giaoDichDTO.getDonGia());
        giaoDich.setDienTich(giaoDichDTO.getDienTich());

        giaoDichService.saveGiaoDich(giaoDich);
        return "redirect:/gd";
    }

    @GetMapping("/xoa/{id}")
    public String deleteGiaoDich(@PathVariable Long id) {
        giaoDichService.deleteGiaoDichById(id);
        return "redirect:/gd";
    }

//    @GetMapping("/chinh-sua/{id}")
//    public String showEditForm(@PathVariable Long id, Model model) {
//        GiaoDich giaoDich = giaoDichService.getGiaoDichById(id);
//        List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
//        model.addAttribute("giaoDich", giaoDich);
//        model.addAttribute("khachHangList", khachHangList);
//        return "/edit";
//    }
//
//    @PostMapping("/chinh-sua/{id}")
//    public String updateGiaoDich(@PathVariable Long id, @ModelAttribute GiaoDich giaoDich) {
//        GiaoDich existingGiaoDich = giaoDichService.getGiaoDichById(id);
//        if (existingGiaoDich != null) {
//            existingGiaoDich.setKhachHang(giaoDich.getKhachHang());
//            existingGiaoDich.setNgayGiaoDich(giaoDich.getNgayGiaoDich());
//            existingGiaoDich.setLoaiDichVu(giaoDich.getLoaiDichVu());
//            existingGiaoDich.setDonGia(giaoDich.getDonGia());
//            existingGiaoDich.setDienTich(giaoDich.getDienTich());
//            giaoDichService.saveGiaoDich(existingGiaoDich);
//        }
//        return "redirect:/gd";
//    }
@GetMapping("/chinh-sua/{id}")
public String showEditForm(@PathVariable Long id, Model model) {
    GiaoDich giaoDich = giaoDichService.getGiaoDichById(id);
    List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
    GiaoDichDTO giaoDichDTO = new GiaoDichDTO();

    // Sao chép dữ liệu từ GiaoDich sang GiaoDichDTO
    giaoDichDTO.setMaGiaoDich(giaoDich.getMaGiaoDich());
    giaoDichDTO.setMaKhachHang(giaoDich.getKhachHang().getMaKhachHang());
    giaoDichDTO.setNgayGiaoDich(giaoDich.getNgayGiaoDich());
    giaoDichDTO.setLoaiDichVu(giaoDich.getLoaiDichVu());
    giaoDichDTO.setDonGia(giaoDich.getDonGia());
    giaoDichDTO.setDienTich(giaoDich.getDienTich());

    model.addAttribute("giaoDich", giaoDichDTO);
    model.addAttribute("khachHangList", khachHangList);
    return "/edit";
}

    @PostMapping("/chinh-sua/{id}")
    public String updateGiaoDich(@PathVariable Long id, @Valid @ModelAttribute("giaoDich") GiaoDichDTO giaoDichDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
            model.addAttribute("khachHangList", khachHangList);
            return "/edit";
        }

        GiaoDich existingGiaoDich = giaoDichService.getGiaoDichById(id);
        if (existingGiaoDich != null) {
            // Cập nhật dữ liệu từ GiaoDichDTO sang GiaoDich
            existingGiaoDich.setKhachHang(khachHangService.getKhachHangById(giaoDichDTO.getMaKhachHang()));
            existingGiaoDich.setNgayGiaoDich(giaoDichDTO.getNgayGiaoDich());
            existingGiaoDich.setLoaiDichVu(giaoDichDTO.getLoaiDichVu());
            existingGiaoDich.setDonGia(giaoDichDTO.getDonGia());
            existingGiaoDich.setDienTich(giaoDichDTO.getDienTich());

            giaoDichService.saveGiaoDich(existingGiaoDich);
        }
        return "redirect:/gd";
    }

//    @PostMapping("/them-moi")
//    public String addGiaoDich(@ModelAttribute GiaoDich giaoDich) {
//        giaoDichService.saveGiaoDich(giaoDich);
//        return "redirect:/gd";
//    }

    @GetMapping("/{id}")
    public String viewGiaoDich(@PathVariable Long id, Model model) {
        model.addAttribute("giaoDich", giaoDichService.getGiaoDichById(id));
        return "/view";
    }

    @GetMapping("/tim-kiem")
    public String searchGiaoDich(@RequestParam String tenKhachHang, @RequestParam String loaiDichVu, Model model) {
        model.addAttribute("giaoDichList", giaoDichService.searchGiaoDich(tenKhachHang, loaiDichVu));
        return "/list";
    }
}
