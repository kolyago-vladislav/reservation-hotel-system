package by.pilipuk.environment.data;

import by.pilipuk.environment.data.entityCreators.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityCreators {

    public final AddressCreator addressCreator;

    public final HotelCreator hotelCreator;

    public final RoomCreator roomCreator;

}
