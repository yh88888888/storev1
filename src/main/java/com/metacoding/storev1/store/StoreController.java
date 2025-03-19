package com.metacoding.storev1.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 1. 컴포넌트 스캔에 등록됨. 2. 컨테이너에 등록됨. 3. 스프링이 관리함. IoC(제어의 역전) → HashSet
public class StoreController {
    @GetMapping("/")
    public String list() {
        return "store/list";
    }

    @GetMapping("/store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    @GetMapping("/store/{id}")
    public String detail(@PathVariable("id") int id) {
        return "store/detail";
    }

    @GetMapping("/store/{id}/update-form")
    public String updateForm(@PathVariable("id") int id) {
        return "store/update-form";
    }

    @GetMapping("/store/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        return "redirect:/";// 만들어져 있으면 무조건 redirect
    }

    @PostMapping("/store/save")
    public String save() {
        return "redirect:/";
    }

    @PostMapping("/store/{id}/update")
    public String update(@PathVariable("id") int id) {
        return "redirect:/store/" + id;
    }

}