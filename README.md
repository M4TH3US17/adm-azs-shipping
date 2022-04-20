<h1>Teste Vaga JR</h1>
<h2>Ferramentas Usadas:</h2>
<ul>
  <li>Banco H2</li>
  <li>GraphQL</li>
  <li>Spring(boot/data/web)</li>
  <li>Lombok</li>
</ul>

<h2>Acesse o link abaixo para iniciar a execução das consultas</h2>
<pre>
  <code>
    http://localhost:8080/graphiql
  </code>
</pre>

<h2> 1 Query (pesquisar tudo)</h2>

<h3>1.1 todos os endereços</h3>
<pre>
<code>
  query {
  findAllEndereco {
    id
    rua
    estado
    bairro
    estado
    cidade
  }
}
</code>
</pre>

<h3>1.2 todos os clientes</h3>
<pre>
  <code>
  query {
  findAllCliente {
    id,
    nome
    email,
    contato,
    endereco {
      id
      rua
      estado
      cidade
      bairro
      numCasa
    }
  }
}
  </code>
</pre>

<h3>1.3 todas as mercadorias com cálculo de peso cubado</h3>
<pre>
  <code>
  query {
  findAllMercadoria {
    transporte
    pesoCubado
  }
}
  </code>
</pre>

<h3>1.4 todos as mercadorias com calculo de cubagem</h3>
<pre>
  <code>
  query {
  findAllMercadoria {
    transporte
    cubagem
  }
}
  </code>
</pre>

<h3>1.5 todos os fretes cadastrados:</h3>
<pre>
  <code>
  query{
  findAllFrete {
    id
    mercadorias {
      id
      transporte
      largura
      altura
      profundidade
      quantidade
      pesoCubado
    }
    cliente {
      id
      nome
      email
      contato
      endereco {
        id
        rua
        estado
        cidade
        bairro
        numCasa
      }
    }
  }
}
  </code>
</pre>

<h2>2 Query (pesquisar por id)</h2>

<h3>2.1 Pesquisar endereço por id</h3>
<pre>
<code>
  query {
  findByEnderecoId(id: 1){
    id
    rua
    estado
    cidade
    bairro
    numCasa
  }
}
</code>
</pre>

<h3>2.2 Pesquisar Cliente por id</h3>
<pre>
<code>
  query {
  findClienteById(id: 3){
    id
    nome
    email
    contato
    endereco {
      id
      rua
      estado
      cidade
      bairro
      numCasa
    }
  }
}
</code>
</pre>

<h3>2.3 Pesquisar Mercadoria por id</h3>
<pre>
<code>
  query {
  findMercadoriaById(id: 1){
    id
    transporte
    largura
    altura
    comprimento
    comprimento
    quantidade
    pesoCubado
  }
}
</code>
</pre>

<h3>2.4 Pesquisar Frete por id</h3>
<pre>
<code>
 query{
  findFreteById(id: 1) {
    id
    mercadorias {
      id
      transporte
      largura
      altura
      profundidade
      quantidade
      pesoCubado
    }
    cliente {
      id
      nome
      email
      contato
      endereco {
        id
        rua
        estado
        cidade
        bairro
        numCasa
      }
    }
  }
}
</code>
</pre>

<h2>3 Mutation (create)</h2>

<h3>3.1 criar um endereço</h3>
<pre>
<code>
  mutation($endereco:EnderecoInput){
  createEndereco(endereco:$endereco){
    id
    rua
    estado
    cidade
    bairro
    numCasa
  }
}
</code>
</pre>

<h3>3.1 Em query variables digite:</h3>
<pre>
<code> 
  {
  "endereco": {
    "rua": "ruaTeste",
    "estado": "estadoTeste",
    "cidade": "cidadeTeste",
    "bairro": "bairroteste",
    "numCasa": 0
  }
}
</code>
</pre>

<h3>3.2 criar um Cliente</h3>
<pre>
<code>
  {
  "endereco": {
    "rua": "ruaTeste",
    "estado": "estadoTeste",
    "cidade": "cidadeTeste",
    "bairro": "bairroteste",
    "numCasa": 0
  }
}
</code>
</pre>

<h3>3.2 Em query variable digite:</h3>
<pre>
<code>
  {
  "cliente": {
    "nome": "Marisa Ferreira",
    "email": "marisa@gmail.com",
    "contato": "(92) 00000-0000",
    "enderecoId": 3
  }
}
</code>
</pre>

<h3>3.3 criar uma nova mercadoria</h3>
<pre>
<code>
  mutation ($mercadoria: MercadoriaInput){
  createMercadoria(input: $mercadoria){
    transporte
    largura
    altura
    profundidade
    quantidade
  }
}
</code>
</pre>

<h3>3.3 em query variables digite:</h3>
<pre>
<code>
  {
  "mercadoria" : {
    "largura": 2.0,
    "altura": 2.0,
    "profundidade": 2.0,
    "quantidade": 2,
    "transporte": "RODOVIARIO"
  }
}
</code>
</pre>

<h3>3.4 criar um Frete</h3>
<pre>
<code>
  ainda está em andamento...
</code>
</pre>

<h2>4 Mutation (update)</h2>
<h3>4.1 atualizar endereço:</h3>
<p><strong>Detalhe:</strong> você pode informar passar qualquer parâmetro para ser atualizado, somente o ID não que não pode ser atualizado.</p>
<pre>
<code>
  mutation {
  updateEndereco(id: 1, rua: "Av. Tambaqui"){
    id
    rua
    estado
    cidade
    bairro
    numCasa
  }
}
</code>
</pre>

<h3>4.2 atualizar Cliente:</h3>
<pre>
<code>
mutation {
  updateCliente(id: 1, nome: "novoNome"){ 
    id
    nome
    email
    endereco{
      id
      rua
      estado
      cidade
      bairro
      numCasa
    }
  }
}

</code>
</pre>

<h3>4.3 atualizar Mercadoria:</h3>
<pre>
<code>
 mutation {
  updateMercadoria(id: 1, transporte: HIDROVIARIO){
    id
    profundidade
    quantidade
    largura
    altura
    transporte
    pesoCubado
  }
}
</code>
</pre>

<h3>4.4 atualizar Frete (add Item):</h3>
<pre>
<code>
 mutation{
  updateFrete(id: 1, mId:4){
    id
    mercadorias{
      id
    }
    cliente{
      nome
      email
      contato
    }
  }
}
</code>
</pre>

<h2>5 Mutation (deletar por id) </h2>
<h3>5.1 deletar Frete</h3>
<pre>
<code>
mutation {
  deleteFreteById(id: 1)
}
</code>
</pre>

<h3>5.2 deletar Cliente</h3>
<pre>
<code>
  mutation {
  deleteClienteById(id: 1)
}
</code>
</pre>
