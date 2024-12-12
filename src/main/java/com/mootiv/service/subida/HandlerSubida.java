package com.mootiv.service.subida;

import com.mootiv.domain.Repositorio;

import java.io.File;

public class HandlerSubida {

    private SubidaStrategy strategy;

    public void setStrategy(Repositorio repo) {
        // logica para setear la estrategia
    }

    public void subir(File file) {
        this.strategy.subirArchivo(file);
    }



}
