package pro.buildmysoftware.orderaccounting;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryOrderDao implements OrderDao {

    private final ConcurrentMap<OrderId, Order> map;

    public InMemoryOrderDao() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public void add(Order order) {
        map.put(order.id(), order);
    }

    @Override
    public Optional<Order> orderBy(OrderId orderId) {
        return Optional.ofNullable(map.get(orderId));
    }
}
