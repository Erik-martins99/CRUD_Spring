package com.projetos.CrudSpring.dto;

public record ProductPutDTO (String id,
                             String name,
                             Integer price_in_cents){
}
