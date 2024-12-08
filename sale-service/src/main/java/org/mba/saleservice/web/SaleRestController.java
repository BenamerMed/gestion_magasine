package org.mba.saleservice.web;

import org.mba.saleservice.dto.SaleRequest;
import org.mba.saleservice.dto.SaleResponse;
import org.mba.saleservice.services.SaleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleRestController {
    @Autowired
    private SaleServiceInterface saleServiceInterface;

    /*
    private final SaleServiceInterface saleServiceInterface;

    public SaleRestController(SaleServiceInterface saleServiceInterface) {
        this.saleServiceInterface = saleServiceInterface;
    }


     */
    @GetMapping("/sales")
    public List<SaleResponse> getSales() {
        return saleServiceInterface.getAll();
    }
    @GetMapping("/sales/{id}")
    public SaleResponse getSale(@PathVariable Integer id){
        return saleServiceInterface.getOne(id);
    }
    @PostMapping("/sales")
    public void addSale(@RequestBody SaleRequest saleRequest){
        saleServiceInterface.add(saleRequest);
    }
    @PutMapping("/sales/{id}")
    public void updateSale(@PathVariable Integer id,@RequestBody SaleRequest saleRequest){
        saleServiceInterface.update(saleRequest,id);
    }
    @DeleteMapping("sales/{id}")
    public void deleteSale(@PathVariable Integer id){
        saleServiceInterface.delete(id);
    }
}
