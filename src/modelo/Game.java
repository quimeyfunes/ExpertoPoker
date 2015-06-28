package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;


import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class Game {

    private static Game instance = null;
    private int playerCount = 0;
    private Pozo pozo;
    private Jugador jugador;
    
    private Game() {
        this.jugador = new Jugador();
        this.pozo = new Pozo();
        pozo.setMonto(1);
        pozo.setApuestaRequerida(1);

    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setMonto(int monto) {
        this.pozo.setMonto(monto);
    }

    public void setApuesta(int apuesta) {
        this.pozo.setApuestaRequerida(apuesta);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void createPlayers(int count) {
        for (int i = 0; i < count; i++) {
            Contrincante contrincante = new Contrincante(i);
            contrincante.setRondasGanadas(1);
            contrincante.setCantidadCall(1);
            contrincante.setCantidadFold(0);
            contrincante.setCantidadRaise(0);

            jugador.getContrincantes().add(contrincante);
        }
    }

    private KnowledgeBase LoadRules() {

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/reglasPoker.drl"), ResourceType.DRL);

        KnowledgeBuilderErrors errors = kbuilder.getErrors();

        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }


        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        return kbase;
    }

    private StatefulKnowledgeSession CreateSession(KnowledgeBase kbase) {
        return kbase.newStatefulKnowledgeSession();
    }

    public void Run() {

        KnowledgeBase base = LoadRules();
        StatefulKnowledgeSession session = CreateSession(base);

        session.insert(jugador);
        List<Contrincante> contrincantes = jugador.getContrincantes();
        for (int i = 0; i < contrincantes.size(); i++) {
            session.insert(contrincantes.get(i));
        }

        session.insert(pozo);

        //WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger(session);
        // an event.log file is created in the log dir (which must exist)
        // in the working directory
        //logger.setFileName("log/event");
        
        contrincantes = jugador.getContrincantes();
        //session.update(session.getFactHandle(contrincantes), contrincantes);

        for (int i = 0; i < contrincantes.size(); i++)
            session.update(session.getFactHandle(contrincantes.get(i)), contrincantes.get(i));

        session.update(session.getFactHandle(pozo), pozo);
        session.update(session.getFactHandle(jugador), jugador);

        session.fireAllRules();

        //logger.writeToDisk();

        session.dispose();
     
        /*
        

                

        }

        System.out.print("Ingrese el id del jugador ganador (-1 si usted gan�): ");
        int id = Integer.parseInt(readLine());
        if (id != -1) {
        contrincante = contrincantes.get(id);
        contrincante.setRondasGanadas(contrincante.getRondasGanadas() + 1);
        }

        // logger.writeToDisk();

        //System.out.println("El jugador tiene " + jugador.getOddsFinales() + " odds.");
        //System.out.println("El pozo tiene " + pozo.getOdds() + " odds.");
        //System.out.println("El jugador tiene " + jugador.getMano());
        //System.out.println("El jugador decide " + jugador.getAccion());


         */

    }

    private static String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String linea = null;
        try {
            linea = reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return linea;
    }
}
