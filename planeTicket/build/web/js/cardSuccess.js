$(document).ready(()=>{
    Swal.fire({
            position: 'center',
            icon: 'success',
            title: "<h2 style='color:lightskyblue'>Kart Eklendi.. Artık Alışveriş İçin Bu Kartı Kullanabilirsiniz</h2>",
            background: 'navy',
            showConfirmButton: false,
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="index.jsp";
          }, 4000); 
});