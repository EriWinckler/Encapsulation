package com.languages.regions;

import com.languages.Languages;

public class Portuguese extends Languages {

    @Override
    public String[] menuText() {
        return new String[] {
                "1 - Adicionar ao inventario",
                "2 - Descartar produto",
                "3 - Listar produtos disponíveis",
                "4 - Vender produto",
                "5 - Sair"
        };
    }

    @Override
    public String[] productTypesText() {
        return new String[] {
                "1 - Bebida",
                "2 - Fruta"
        };
    }

    @Override
    public String welcomeText() {
        return "O que você gostaria de fazer?";
    }

    @Override
    public String startPromptText() {
        return "Selecione um valor entre 1 e 5:";
    }
}
