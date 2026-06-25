import java.nio.channels.NonReadableChannelException;
import java.nio.file.FileAlreadyExistsException;

public class Main{
    public static void main(String[] args){
        Boolean operando = true;
        ArvoreAVL avBinary = new ArvoreAVL();
        while(operando == true){
            
            System.out.println("Digite as operações que você deseja fazer: ");
            System.out.println("i)Inserir r)Remover b)Buscar s)Sair");
            String escolha = Teclado.leString();
            escolha = escolha.replace(" ","");
            escolha = escolha.toLowerCase();

            char[] escolhaChar = escolha.toCharArray();
            StringBuilder stringBuilder;
            switch (escolhaChar[0]){
                case 'i':
                    stringBuilder = new StringBuilder();
                    for(int i = 1; i < escolhaChar.length; i++){
                        stringBuilder.append(escolhaChar[i]);
                    }

                    avBinary.Inserir(Integer.parseInt(stringBuilder.toString()));
                    System.out.println("Inserido número " + stringBuilder.toString());

                    avBinary.printTree();
                    
                    break;
                    
                case 'r':
                    stringBuilder = new StringBuilder();
                    for(int i = 1; i < escolhaChar.length; i++){
                        stringBuilder.append(escolhaChar[i]);
                    }
                    
                    avBinary.Remover(Integer.parseInt(stringBuilder.toString()));
                    System.out.println("Removido número " + stringBuilder.toString());

                    avBinary.printTree();
                    break;
                    
                case 'b':
                    stringBuilder = new StringBuilder();
                    for(int i = 1; i < escolhaChar.length; i++){
                        stringBuilder.append(escolhaChar[i]);
                    }

                    System.out.println("Buscando o número " + stringBuilder.toString());
                    System.out.println("Caminho percorrido: ");
                    boolean numeroExiste = avBinary.Procurar(Integer.parseInt(stringBuilder.toString()));
                    System.out.println(numeroExiste ? "O número existe na árvore" : "O número não existe na árvore");
                    break;
                    
                case 's':
                    operando = false;
                    break;
                    
                default:
                    System.out.println("Operação não reconhecida");
                    break;
            }
        }
        
    }
}