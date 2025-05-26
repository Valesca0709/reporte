package mircrosRep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mircrosRep.dto.VentaDTO;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    @Autowired
    private RestTemplate restTemplate;

    private final String VENTAS_URL = "http://localhost:8040/api/ventas";
    //trae los reportes de una venta de una sucursal
    public List<VentaDTO> obtenerVentasPorSucursal(int idSucursal) {
        String url = VENTAS_URL + "?sucursal=" + idSucursal; 

        VentaDTO[] ventasArray = restTemplate.getForObject(url, VentaDTO[].class);

        if (ventasArray == null) {
            throw new RuntimeException("No se pudieron obtener las ventas de la sucursal ID: " + idSucursal);
        }

        return Arrays.stream(ventasArray)
                .filter(v -> v.getIdSucursal() == idSucursal)
                .collect(Collectors.toList());
    }
}

