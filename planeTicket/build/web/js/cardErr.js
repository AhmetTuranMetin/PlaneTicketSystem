$(document).ready(()=>{
    Swal.fire({
            position: 'center',
            icon: 'error',
            title: "<h2 style='color:lightskyblue'>Kart Zaten Mevcut.. Lütfen Farklı Bir Kart Eklemeyi Deneyiniz</h2>",
            background: 'navy',
            showConfirmButton: false,
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="addCard.jsp";
          }, 4000); 
});