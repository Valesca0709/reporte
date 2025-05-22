package mircrosRep.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mircrosRep.dto.ReporteVentaDTO;
import mircrosRep.dto.VentaDTO;

import java.util.*;

@Service
public class ReporteService {

    private final RestTemplate restTemplate;

    public ReporteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ReporteVentaDTO> obtenerVentasTotales() {
        VentaDTO[] ventas = restTemplate.getForObject("http://localhost:8082/api/ventas", VentaDTO[].class);

        ReporteVentaDTO resumen = new ReporteVentaDTO();
        resumen.setSucursal("General");
        resumen.setCantidadVentas(ventas.length);

        double total = 0;
        for (VentaDTO venta : ventas) {
            total += venta.getTotalVenta();
        }

        resumen.setTotalVentas(total);

        return List.of(resumen);
}


}

