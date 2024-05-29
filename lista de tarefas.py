class Tarefa:
    def __init__(self, descricao, prioridade, categoria):
        self.descricao = descricao
        self.prioridade = prioridade
        self.categoria = categoria
        self.concluida = False

class ListaTarefas:
    def __init__(self):
        self.tarefas = []

    def adicionar_tarefa(self, tarefa):
        self.tarefas.append(tarefa)

    def listar_tarefas(self):
        if not self.tarefas:
            print("Não há tarefas cadastradas.")
        else:
            for i, tarefa in enumerate(self.tarefas, start=1):
                print(f"{i}. [{tarefa.categoria}] {tarefa.descricao} - Prioridade: {tarefa.prioridade} - Concluída: {'Sim' if tarefa.concluida else 'Não'}")

    def marcar_tarefa_concluida(self, indice):
        if 1 <= indice <= len(self.tarefas):
            self.tarefas[indice - 1].concluida = True
            print("Tarefa marcada como concluída.")
        else:
            print("Índice inválido.")

    def exibir_por_prioridade(self, prioridade):
        print(f"Tarefas com prioridade {prioridade}:")
        for tarefa in self.tarefas:
            if tarefa.prioridade == prioridade:
                print(f"- {tarefa.descricao}")

    def exibir_por_categoria(self, categoria):
        print(f"Tarefas na categoria {categoria}:")
        for tarefa in self.tarefas:
            if tarefa.categoria == categoria:
                print(f"- {tarefa.descricao}")


def exibir_menu():
    print("\n===== Menu de Comandos =====")
    print("1. Adicionar Tarefa")
    print("2. Listar Tarefas")
    print("3. Marcar Tarefa como Concluída")
    print("4. Exibir Tarefas por Prioridade")
    print("5. Exibir Tarefas por Categoria")
    print("6. Sair")

# Função para adicionar tarefa
def adicionar_tarefa(lista_tarefas):
    descricao = input("Digite a descrição da tarefa: ")
    prioridade = input("Digite a prioridade da tarefa: ")
    categoria = input("Digite a categoria da tarefa: ")
    tarefa = Tarefa(descricao, prioridade, categoria)
    lista_tarefas.adicionar_tarefa(tarefa)
    print("Tarefa adicionada com sucesso.")

# Função principal
def main():
    lista_tarefas = ListaTarefas()

    while True:
        exibir_menu()
        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            adicionar_tarefa(lista_tarefas)

        elif opcao == "2":
            lista_tarefas.listar_tarefas()

        elif opcao == "3":
            indice = int(input("Digite o índice da tarefa a ser marcada como concluída: "))
            lista_tarefas.marcar_tarefa_concluida(indice)

        elif opcao == "4":
            prioridade = input("Digite a prioridade para exibir as tarefas: ")
            lista_tarefas.exibir_por_prioridade(prioridade)

        elif opcao == "5":
            categoria = input("Digite a categoria para exibir as tarefas: ")
            lista_tarefas.exibir_por_categoria(categoria)

        elif opcao == "6":
            print("Saindo do programa...")
            break

        else:
            print("Opção inválida. Por favor, escolha uma opção válida.")

if __name__ == "__main__":
    main()
