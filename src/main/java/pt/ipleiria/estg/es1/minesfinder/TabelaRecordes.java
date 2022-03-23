package pt.ipleiria.estg.es1.minesfinder;

import java.util.ArrayList;

public class TabelaRecordes{
    private String nomeUtilizador;
    private long tempoJogo;
    private ArrayList<TabelaRecordesListener> listeners;

    public TabelaRecordes(){
        nomeUtilizador = "Anónimo";
        tempoJogo = 9999999;
        listeners = new ArrayList<>();
    }

    public long getTempoJogo() {
        return tempoJogo;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    protected void setRecorde(String nomeUtilizador, long tempoJogo){
        this.nomeUtilizador = nomeUtilizador;
        this.tempoJogo = tempoJogo;
        notifyRecordesActualizados();
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list) {
        listeners.add(list);
    }
    public void removeTabelaRecordesListener(TabelaRecordesListener list) {
        listeners.remove(list);
    }

    private void notifyRecordesActualizados() {
        for (TabelaRecordesListener list:listeners)
            list.recordesActualizados(this);
    }

}
