$(document).ready(()=>{
    Swal.fire({
            position: 'top-end',
            icon: 'error',
            title: "<h2 style='color:goldenrod'>Girdiğiniz Bilgilerde Firma Zaten Mevcut</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="companyList.jsp";
          }, 4000); 
});