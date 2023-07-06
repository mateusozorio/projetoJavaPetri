package teste;
import java.util.Scanner;

public class tarefa {

    public static void inserirTarefa(String[] lista, int linhas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a tarefa (maximo de 50 caracteres): ");
        String tarefa = scanner.next();
        while (tarefa == null || tarefa.isEmpty() || tarefa.length() > 50) {
            System.out.println("Entrada invalida. Tente novamente (maximo de 50 caracteres): ");
            tarefa = scanner.next();
        }
        lista[linhas] = tarefa;
        System.out.println("Tarefa adicionada.");
    }

    public static void mostrarTarefas(String[] lista, int linhas) {
        System.out.println("ID | Tarefa");

        for (int i = 0; i < linhas; ++i) {
            System.out.println((i + 1) + " | " + lista[i]);
        }

        System.out.println("-----------------------");
    }

    public static void removerTarefa(String[] lista, int linhas, int idTarefa) {
        if (idTarefa >= 1 && idTarefa <= linhas) {
            int indiceTarefa = idTarefa - 1;
            if (lista[indiceTarefa] != null) {
                lista[indiceTarefa] = null;
                System.out.println("Tarefa removida.");
            } else {
                System.out.println("Tarefa nao encontrada.");
            }
        } else {
            System.out.println("Numero de tarefa invalido.");
        }
    }

    public static void contarTarefas(String[] lista, int linhas) {
        int contador = 0;
        for (int i = 0; i < linhas; i++) {
            if (lista[i] != null) {
                contador++;
            }
        }
        System.out.println("O total de tarefas cadastradas é: " + contador);
    }

    public static void pesquisarTarefa(String[] lista, int linhas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a tarefa que deseja pesquisar: ");
        String tarefaPesquisada = scanner.next();

        boolean encontrada = false;
        for (int i = 0; i < linhas; i++) {
            if (lista[i] != null && lista[i].equalsIgnoreCase(tarefaPesquisada)) {
                encontrada = true;
                System.out.println("A tarefa '" + lista[i] + "' foi encontrada no índice " + i);
            }
        }

        if (!encontrada) {
            System.out.println("A tarefa não foi encontrada.");
        }
    }

    public static void editarTarefa(String[] lista, int linhas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID da tarefa a ser editada: ");

            int numeroTarefa = scanner.nextInt();
            if (numeroTarefa >= 1 && numeroTarefa <= linhas) {
                int indiceTarefa = numeroTarefa - 1;
                System.out.println("Tarefa atual:");
                System.out.println("ID: " + (indiceTarefa + 1));
                System.out.println("Descricao: " + lista[indiceTarefa]);
                System.out.println("Digite a nova descricao da tarefa:");
                String novaDescricao = scanner.next();
                while (novaDescricao == null || novaDescricao.isEmpty() || novaDescricao.length() > 50) {
                    System.out.println("Entrada invalida. Tente novamente (maximo de 50 caracteres): ");
                    novaDescricao = scanner.next();
                }
                lista[indiceTarefa] = novaDescricao;
                System.out.println("Descricao da tarefa atualizada.");
            } else {
                System.out.println("Numero de tarefa invalido.");
            }
        }

    public static void menu (){
        System.out.println("Escolha uma opcao:");
        System.out.println("1 - Mostrar lista de tarefas");
        System.out.println("2 - Inserir tarefa");
        System.out.println("3 - Remover tarefa");
        System.out.println("4 - Editar tarefa");
        System.out.println("5 - Contar tarefas");
        System.out.println("6 - Pesquisar tarefa específica");
        System.out.println("0 - Sair");

    }

    public static void main(String[] args) {
        int tarefas = 0;
        int MAX_TAREFAS = 100;
        String[] lista = new String[MAX_TAREFAS];

        System.out.println("Ola usuario seja bem vindo(a)");
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            while (!scanner.hasNextInt()) {
                System.out.println("Opcao invalida! Insira um numero inteiro.");
                scanner.next();
            }

            opcao = scanner.nextInt();
            if (opcao == 0) {
                System.out.println("Agradecemos por usar nosso sistema");
            }

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    if (tarefas == 0) {
                        System.out.println("Nenhuma tarefa cadastrada");
                    } else {
                        mostrarTarefas(lista, tarefas);
                    }
                    break;
                case 2:
                    if (tarefas < MAX_TAREFAS) {
                        inserirTarefa(lista, tarefas);
                        ++tarefas;
                    } else {
                        System.out.println("Nao e possivel adicionar mais tarefas. A lista esta cheia.");
                    }
                    break;
                case 3:
                    if (tarefas == 0) {
                        System.out.println("nenhuma tarefa cadastrada");
                    } else {
                        System.out.print("Digite o ID da tarefa a ser removida: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Numero de tarefa invalido. Digite um numero inteiro: ");
                            scanner.next();
                        }
                        int idTarefa = scanner.nextInt();
                        removerTarefa(lista, tarefas, idTarefa);
                    }
                        break;
                    case 4:
                        if (tarefas == 0) {
                            System.out.println("Nenhuma tarefa cadastrada");
                        } else {
                            editarTarefa(lista, tarefas);
                        }
                        break;
                case 5:
                    if (tarefas == 0){
                        System.out.println("Nenhuma tarefa cadastrada");
                    }
                    else{
                        contarTarefas(lista, tarefas);
                    }
                    break;
                case 6:
                    if (tarefas == 0){
                        System.out.println("Nenhuma tarefa cadastrada");
                    }
                    else{
                        pesquisarTarefa(lista, tarefas);
                    }
                    break;
                    default:
                        System.out.println("Opcao invalida!");
                }
            } while (opcao != 0);
        }
    }
