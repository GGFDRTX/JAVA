import java.util.Scanner;

public class SistemaValutazioneFisso {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Materie per ogni livello
        String[] materieElementare = {"Matematica", "Inglese", "Scienze"};
        String[] materieIntermedio = {"Matematica", "Inglese", "Storia", "Biologia"};
        String[] materieSuperiore = {"Matematica", "Inglese", "Fisica", "Chimica", "Informatica"};

        // Numero massimo di studenti
        int massimoStudenti = 100;

        // Archiviazione dati
        String[] nomiStudenti = new String[massimoStudenti];
        String[] livelliIstruzione = new String[massimoStudenti];
        int[][] voti = new int[massimoStudenti][5];
        int numeroStudenti = 0;

        while (true) {
            System.out.println("\n--- Sistema di Valutazione ---");
            System.out.println("1. Aggiungi uno Studente");
            System.out.println("2. Inserisci i Voti");
            System.out.println("3. Visualizza il Rapporto Studente");
            System.out.println("4. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consumare la linea

            switch (scelta) {
                case 1:
                    // Aggiungi uno Studente
                    if (numeroStudenti < massimoStudenti) {
                        System.out.print("Inserisci il nome dello studente: ");
                        nomiStudenti[numeroStudenti] = scanner.nextLine();

                        System.out.print("Inserisci il livello di istruzione (Elementare/Intermedio/Superiore): ");
                        livelliIstruzione[numeroStudenti] = scanner.nextLine();

                        numeroStudenti++;
                        System.out.println("Studente aggiunto con successo!");
                    } else {
                        System.out.println("Numero massimo di studenti raggiunto!");
                    }
                    break;

                case 2:
                    // Inserisci i Voti
                    System.out.print("Inserisci il numero dello studente (1-" + numeroStudenti + "): ");
                    int numeroStudente = scanner.nextInt();
                    scanner.nextLine(); // Consumare la linea

                    if (numeroStudente > 0 && numeroStudente <= numeroStudenti) {
                        int indice = numeroStudente - 1;
                        String livello = livelliIstruzione[indice];
                        String[] materie = ottieniMateriePerLivello(livello, materieElementare, materieIntermedio, materieSuperiore);

                        if (materie != null) {
                            for (int i = 0; i < materie.length; i++) {
                                System.out.print("Inserisci il voto (su 100) per " + materie[i] + ": ");
                                voti[indice][i] = scanner.nextInt();
                            }
                            System.out.println("Voti inseriti con successo!");
                        } else {
                            System.out.println("Livello di istruzione non valido per lo studente!");
                        }
                    } else {
                        System.out.println("Numero studente non valido!");
                    }
                    break;

                case 3:
                    // Visualizza il Rapporto Studente
                    System.out.print("Inserisci il numero dello studente (1-" + numeroStudenti + "): ");
                    numeroStudente = scanner.nextInt();
                    scanner.nextLine(); // Consumare la linea

                    if (numeroStudente > 0 && numeroStudente <= numeroStudenti) {
                        int indice = numeroStudente - 1;
                        String nome = nomiStudenti[indice];
                        String livello = livelliIstruzione[indice];
                        String[] materie = ottieniMateriePerLivello(livello, materieElementare, materieIntermedio, materieSuperiore);

                        if (materie != null) {
                            System.out.println("\n--- Rapporto per " + nome + " (" + livello + ") ---");
                            boolean bocciato = false;

                            for (int i = 0; i < materie.length; i++) {
                                int voto = voti[indice][i];
                                char votoLettera = calcolaVotoLettera(voto);

                                System.out.println(materie[i] + ": " + voto + " (" + votoLettera + ")");
                                if (votoLettera == 'F') {
                                    bocciato = true;
                                }
                            }

                            if (bocciato) {
                                System.out.println("\nLo studente è stato bocciato in una o più materie. Iscriviti ai corsi estivi.");
                            } else {
                                System.out.println("\nLo studente ha superato tutte le materie.");
                            }
                        } else {
                            System.out.println("Livello di istruzione non valido per lo studente!");
                        }
                    } else {
                        System.out.println("Numero studente non valido!");
                    }
                    break;

                case 4:
                    // Esci
                    System.out.println("Uscita in corso...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opzione non valida! Riprova.");
            }
        }
    }

    // Funzione per calcolare il voto in lettere
    public static char calcolaVotoLettera(int voto)
     {
        if (voto >= 90) return 'A';
        if (voto >= 80) return 'B';
        if (voto >= 70) return 'C';
        if (voto >= 60) return 'D';
        if (voto >= 50) return 'E';
        return 'F';
    }

    // Funzione per ottenere le materie in base al livello di istruzione
    public static String[] ottieniMateriePerLivello(String livello, String[] elementare, String[] intermedio, String[] superiore) {
        switch (livello.toLowerCase()) {
            case "elementare":
                return elementare;
            case "intermedio":
                return intermedio;
            case "superiore":
                return superiore;
            default:
                return null;
        }
    }
}
