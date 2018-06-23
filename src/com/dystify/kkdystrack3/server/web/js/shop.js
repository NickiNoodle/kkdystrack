$(document).ready(() => {

  let client = null;

  let init = () => {
    let url = 'ws://127.0.0.1:8000/data';
    client = Stomp.client(url);
    client.connect({}, (frame) => {
      console.log('Connected ' + frame);
      client.subscribe('/socket/newitem', (greeting) => {
        console.log(JSON.parse(greeting.body).content);
      });
    });
  }

  init();

  $('.addItem').on('click', () => {
    let name = $('.name').val();
    if (name.length != 0) {
      $.ajax({
        type: 'POST',
        url: '/shop/add',
        data: JSON.stringify({'name': name}),
        success: (data) => {
          console.log(data);
          client.send('/app/data', {}, JSON.stringify({'content': name}));
        },
        contentType: 'application/json'
      });
    };
  });
});