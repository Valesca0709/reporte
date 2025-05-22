package mircrosRep.controller;

import org.springframework.web.bind.annotation.*;

import mircrosRep.dto.ReporteVentaDTO;
import mircrosRep.service.ReporteService;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/ventas-totales")
    public List<ReporteVentaDTO> ventasTotales() {
        return reporteService.obtenerVentasTotales();
    }

}

