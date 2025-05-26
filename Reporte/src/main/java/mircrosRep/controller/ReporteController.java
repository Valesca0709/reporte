package mircrosRep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mircrosRep.dto.VentaDTO;
import mircrosRep.service.ReporteService;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<VentaDTO>> obtenerReportePorSucursal(@PathVariable int idSucursal) {
        List<VentaDTO> reporte = reporteService.obtenerVentasPorSucursal(idSucursal);
        return ResponseEntity.ok(reporte);
    }
}
