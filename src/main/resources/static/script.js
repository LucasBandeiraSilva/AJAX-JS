
    function getJson(url) {
      const promise = new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.onload = function() {
          if (xhr.status >= 200 && xhr.status < 400) {
            // SUCESSO
            resolve(JSON.parse(xhr.responseText));
          } else {
            // ERROS
            const objErro = {
              codigo: xhr.status,
              mensagem: 'Erro'
            };
            reject(objErro);
          }
        }
        xhr.send();
      });
      return promise;
    }

    function carregarDados() {
      const promise = getJson('http://127.0.0.1:8080/dados');
      promise.then(function(dados) {
        // Tratar dados recebidos em resp
        document.getElementById('nome').innerHTML = dados.nome;
        document.getElementById('email').innerHTML = dados.email;
        document.getElementById('telefone').innerHTML = dados.telefone;
        document.getElementById('dataNascimento').innerHTML = dados.dataNascimento;
        const aLinkedIn = document.getElementById('linkedin');
        aLinkedIn.href = dados.linkedin;
        aLinkedIn.innerHTML = 'LinkedIn';
        const aGitHub = document.getElementById('github');
        aGitHub.href = dados.github;
        aGitHub.innerHTML = 'GitHub';

        // Preencha os campos adicionais da mesma maneira
        document.getElementById('expprof').querySelector('h3').innerHTML = 'Experiências Profissionais';

        const expprofUl = document.querySelector('#expprof ul');
        dados.experienciaProfissional.forEach(experiencia => {
          const li = document.createElement('li');
          li.innerHTML = `
            <h4>${experiencia.empresa}</h4>
            <p>${experiencia.cargo}</p>
            <p>${experiencia.periodo}</p>
          `;
          expprofUl.appendChild(li);
        });

        document.getElementById('formacad').querySelector('h3').innerHTML = 'Formação Acadêmica';

        const formacadUl = document.querySelector('#formacad ul');
        dados.formacaoAcademica.forEach(formacao => {
          const li = document.createElement('li');
          li.innerHTML = `
            <h4>${formacao.curso}</h4>
            <p>${formacao.instituicao}</p>
          `;
          formacadUl.appendChild(li);
        });

        document.getElementById('idiomas').querySelector('h3').innerHTML = 'Idiomas';

        const idiomasTable = document.querySelector('#idiomas table tbody');
        dados.idiomas.forEach(idioma => {
          const tr = document.createElement('tr');
          tr.innerHTML = `
            <th>${idioma.idioma}</th>
            <td>${idioma.leitura}</td>
            <td>${idioma.escrita}</td>
            <td>${idioma.conversacao}</td>
          `;
          idiomasTable.appendChild(tr);
        });

        document.getElementById('conhecimentos').querySelector('h3').innerHTML = 'Conhecimentos';

        const conhecimentosUl = document.querySelector('#conhecimentos ul');
        dados.conhecimentos.forEach(conhecimento => {
          const li = document.createElement('li');
          li.innerHTML = conhecimento;
          conhecimentosUl.appendChild(li);
        });
      }).catch(function(err) {
        alert(err.mensagem + ' ' + err.codigo);
      });
    }

    document.addEventListener('DOMContentLoaded', function() {
      carregarDados();
      carregarSeguidores();
    });
