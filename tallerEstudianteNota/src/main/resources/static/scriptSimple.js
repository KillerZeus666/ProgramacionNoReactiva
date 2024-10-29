function enviaDatos() {

    let _nom = document.forms["demo"]["nombre"].value;
                     if (_nom == "") {
                       alert("Debe registrar un nombre");
                       return false;
                     }
    let _ape = document.forms["demo"]["apellido"].value;
                       if (_ape == "") {
                         alert("Debe registrar un apellido");
                         return false;
                       }
    let _cor = document.forms["demo"]["correo"].value;
                if (_cor == "") {
                   alert("Debe digitar un correo valido");
                   return false;
                 }
    let datos = {
      nombre: _nom,
      apellido: _ape,
      correo: _cor
    };
    
    
    const options = {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json',
    },
    body: JSON.stringify(datos),
    };
    
    fetch('http://localhost:8080/api/crea', options)
      .then(data => {
          if (!data.ok) {
            throw Error(data.status);
           }
           return data.json();
          }).then(datos => {
          console.log(datos);
          }).catch(e => {
          console.log(e);
          });
    
       return false;
    }
    function traerEstudiantes()
    {
        fetch('http://localhost:8080/api/estudiantes')
.then(res => {
    return res.json();
})
.then(datos => {
    datos.forEach(est => {
        let temp = ``;
            temp += `<tr>`;
            temp += `<td> ${est.id}  </td>`;
            temp += `<td> ${est.nombre} </td>`;
            temp += `<td>  ${est.apellido} </td>`;
            temp += `<td> ${est.correo} </td></tr>`;
            document.querySelector('table').insertAdjacentHTML('beforeend', temp);

    });
})
.catch(error => console.log(error));
    }
    