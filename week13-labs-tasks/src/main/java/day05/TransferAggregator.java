package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    public List<TransferPerClient> readTransfers(Path path) {
        Map<String, TransferPerClient> transfers = new TreeMap<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                String sourceClientId = part[0];
                String targetClientId = part[1];
                int amount = Integer.parseInt(part[2]);

                TransferPerClient source = transfers.computeIfAbsent(sourceClientId,
                        k -> new TransferPerClient(sourceClientId));
                source.decrease(amount);

                TransferPerClient target = transfers.computeIfAbsent(targetClientId,
                        k -> new TransferPerClient(targetClientId));
                target.increase(amount);

            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot open the file", e);
        }
        return new ArrayList<>(transfers.values());
    }

    public static void main(String[] args) {
        List<TransferPerClient> transfers = new TransferAggregator()
               .readTransfers(Paths.get("src/main/resources/transfers.csv"));

        for (TransferPerClient actual: transfers) {
            System.out.printf("%s %,12d %5d\n",
                    actual.getClientId(), actual.getSum(), actual.getNumberOfTransactions());
        }
    }
}
