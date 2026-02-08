package com.example.otica.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;           // Qual pedido pertence

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;         // Qual produto foi escolhido

    private int quantidade;          // Quantas unidades
    private double precoUnitario;    // Preço no momento da compra
    private double subtotal;         // quantidade * precoUnitario

}
