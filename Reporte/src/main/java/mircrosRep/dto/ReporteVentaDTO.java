package mircrosRep.dto;
import lombok.Data;

@Data
public class ReporteVentaDTO {
    private int idVenta;
    private int idSucursal;
    private double totalVenta;
    private String fechaVenta;
}

