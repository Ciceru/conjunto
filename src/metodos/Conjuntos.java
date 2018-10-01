package metodos;

public class Conjuntos {
	// Atributos

	private int tamanho = 0;
	private int indiceDeUso = 0;
	private int[] array = null;

	// Metodos

	public Conjuntos(int tamanho) throws Exception {
		if (tamanho <= 0)
			throw new Exception("Tamnho nao pode ser <= 0");
		array = new int[tamanho];
		this.tamanho = tamanho;
		indiceDeUso = 0;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getIndiceDeUso() {
		return indiceDeUso;
	}

	public int getElemento(int posicao) throws Exception {
		if (posicao < 0)
			throw new Exception("Posicao nao pode ser < 0");
		if (posicao >= indiceDeUso)
			throw new Exception("Posicao nao pode ser >= indice de Uso");
		return array[posicao];
	}

	public void setElemento(int elemento) throws Exception {
		if (tamanho == indiceDeUso)
			throw new Exception("Conjunto esta Xeio");
		if (buscar(elemento))
			throw new Exception("Elemento ja Existe");
		array[indiceDeUso] = elemento;
		indiceDeUso++;
	}

	public boolean buscar(int elemento) {
		for (int pos = 0; pos < indiceDeUso; pos++) {
			if (elemento == array[pos])
				return true;
		}
		return false;
	}

	public String getConjunto() {
		String saida = "{ ";
		for (int pos = 0; pos < indiceDeUso; pos++) {
			saida = saida + array[pos];
			if (pos < indiceDeUso - 1)
				saida = saida + ", ";
		}
		saida = saida + "}";
		return saida;
	}

	public boolean eConjuntoVazio() {
		return (indiceDeUso == 0);
	}

	public Conjuntos uniao(Conjuntos objeto) throws Exception {
		try {
			int tamanhoConjuntoNovo = this.indiceDeUso + objeto.getIndiceDeUso();
			Conjuntos aux = new Conjuntos(tamanhoConjuntoNovo);
			for (int pos = 0; pos < indiceDeUso; pos++) {
				aux.array[pos] = this.array[pos];
			}
			aux.indiceDeUso = this.indiceDeUso;
			for (int pos = 0; pos < objeto.getIndiceDeUso(); pos++) {
				try {
					aux.setElemento(objeto.array[pos]);
				} catch (Exception e) {
				}
			}
			return aux;
		} catch (Exception erro) {
			throw erro;
		}
	}

	public Conjuntos intersecao(Conjuntos objeto) throws Exception {
		try {
			int tamanhoDoConjuntoNovo = this.indiceDeUso;
			if (objeto.indiceDeUso < this.indiceDeUso)
				tamanhoDoConjuntoNovo = objeto.indiceDeUso;
			Conjuntos aux = new Conjuntos(tamanhoDoConjuntoNovo);
			for (int pos = 0; pos < this.indiceDeUso; pos++) {
				if (objeto.buscar(this.array[pos])) {
					aux.array[aux.indiceDeUso] = this.array[pos];
					aux.indiceDeUso++;
				}
			}
			return aux;
		} catch (Exception erro) {
			throw erro;
		}
	}

	public Conjuntos diferenca(Conjuntos objeto) throws Exception {
		try {
			int tamanhoDoConjuntoNovo = this.indiceDeUso;
			Conjuntos aux = new Conjuntos(tamanhoDoConjuntoNovo);
			for (int pos = 0; pos < this.indiceDeUso; pos++) {
				if (!(objeto.buscar(this.array[pos]))) {
					aux.array[aux.indiceDeUso] = this.array[pos];
					aux.indiceDeUso++;
				}
			}
			return aux;
		} catch (Exception erro) {
			throw erro;
		}
	}

	public boolean eSubConjunto(Conjuntos objeto) throws Exception {
		try {
			if (diferenca(objeto).eConjuntoVazio())
				return true;

		} catch (Exception erro) {
			throw erro;

		}
		return false;
	}

}
