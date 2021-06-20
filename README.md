#Problem challenge<br />
We would like to have a RESTful API for our statistics. The main use case for the API is to calculate realtime statistics for the last 60 seconds of transactions.
The API needs the following endpoints:<br /><br />
● POST /transactions​ – called every time a transaction is made. It is also the sole input of this rest API.<br />
● GET /statistics​ – returns the statistic based of the transactions of the last 60 seconds.<br />
● DELETE /transactions​ – deletes all transactions.<br />
<br /><br /><br />
#Solution:<br />
● 2 REST Api controlers for handling /transactions and /statistics<br />
● Services running the business logic to calculate total sum.<br />
● Took Concurrent Hashmap to make the transaction data threadsafe. As hashmap wont block whole data structure while reading/writing<br />
● Daemon service is running over the transaction data to remove the expired transactions.<br />
