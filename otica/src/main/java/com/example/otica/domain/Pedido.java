package com.example.otica.domain;

import com.example.otica.enums.FormaPagamento;
import com.example.otica.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;                    // Quem está comprando

    private LocalDateTime dataPedido;           // Quando foi feito
    private LocalDateTime dataEntrega;          // Previsão de entrega

    @Enumerated(EnumType.STRING)
    private StatusPedido status;                // PENDENTE, CONFIRMADO, ENTREGUE, CANCELADO

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private double subtotal;
    private double desconto;
    private double total;
}
