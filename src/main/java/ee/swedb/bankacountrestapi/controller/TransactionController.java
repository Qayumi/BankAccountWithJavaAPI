package ee.swedb.bankacountrestapi.controller;

import ee.swedb.bankacountrestapi.model.Transaction;
import ee.swedb.bankacountrestapi.services.serviceImp.TransactionServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionServiceImp transactionServiceImp;

    public TransactionController(TransactionServiceImp transactionServiceImp) {
        this.transactionServiceImp = transactionServiceImp;
    }

    @PostMapping()
    public void createTransaction(@RequestBody Transaction transaction) {
        this.transactionServiceImp.createTransaction(transaction);
    }

    @GetMapping()
    public List<Transaction> getAllTransaction() {
        return this.transactionServiceImp.findAllTransaction();
    }


    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable("id") Long transactionId, @RequestBody Transaction transaction) {
        return this.transactionServiceImp.updateTransaction(transactionId, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") Long transactionId) {
        this.transactionServiceImp.deleteTransaction(transactionId);
    }

    @RequestMapping("/{id}")
    public List<Transaction> getTransactionByAccountId(@PathVariable("id") Long accountId) {
        return this.transactionServiceImp.findAllTransactionByAccountId(accountId);
    }

}
