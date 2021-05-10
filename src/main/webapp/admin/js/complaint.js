let listfeedback = [];

const renderData = function () {
    db.collection('complaint').get().then(data => {

        data.docs.forEach(element => {
            const comment = element.data();
            listfeedback.push(comment);
        });

        listfeedback.forEach(element => {

            $('.tabeldata').append('<tr><td>'+element.MeterNo+'</td><td>'+element.Subject+'</td><td>'+element.Description+'</td></tr>');
        });

    });
}


renderData();

