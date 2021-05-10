let listfeedback = [];

const renderData = function () {
    db.collection('feedback').get().then(data => {

        data.docs.forEach(element => {
            const comment = element.data();
            listfeedback.push(comment);
        });

        listfeedback.forEach(element => {

            $('.tabeldata').append('<tr><td>'+element.CustName+'</td><td>'+element.Comment+'</td><td>'+element.Rating+'</td></tr>');
        });

    });
}


renderData();

