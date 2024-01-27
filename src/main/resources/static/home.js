function enviarDados() {

            // Coleta dados do formulário
            let nome = document.getElementById('nome').value
            let descricao = document.getElementById('descricao').value;
            let quantidade = document.getElementById('quantidade').value

            // Cria um objeto com os dados
            var dados = {
                nome:nome,
                descricao:descricao,
                quantidade:quantidade

            };

          // Envia os dados para o back-end usando Fetch
        fetch("http://localhost:8080/api/adicionar",{
        method:'POST',
        body: JSON.stringify(dados),
        headers: { "Content-Type" : "application/json" }

    }).then(res => res.json())
    .then(data =>{

    })

    }

 function carregar(){
 console.log("lista carregada");
   fetch('/api/lista')
                .then(response => response.json())
                .then(data => {

                    const lista = document.getElementById("lista");
                    lista.innerHTML = "<h2>Lista</h2>";
                    data.forEach(listas => {
                        lista.innerHTML += `<p>Nome: ${listas.nome},---- Descrição: ${listas.descricao},---- Quantidade: ${listas.quantidade}</p>`;
                    });
                })
                .catch(error => console.error('Erro ao carregar lista:', error));

}
function esconder(){
   fetch('/api/lista')
                .then(response => response.json())
                .then(data => {

                    const lista = document.getElementById("lista");
                    lista.innerHTML = "";

                })
                .catch(error => console.error('Erro ao carregar lista:', error));

}

function hello(){

   alert("lista ok")
}