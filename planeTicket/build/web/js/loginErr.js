$(document).ready(()=>{
    Swal.fire({
        position: 'center',
            icon: 'error',
            title: "<h2 style='color:lightskyblue'>Kullanıcı Bulunamadı!! Lütfen Üye Olunuz veya Bilgilerinizi Doğru Girip Tekrar Giriş Yapmayı Deneyiniz</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="login.jsp";
          }, 4000); 
});