package me.mat.port.coin.service.component;

/**
 * @author Mat
 *
 * Acts as an interface for multiple services
 * This can be anything from de registering keys put in fields,
 * closing connection pools or beginning the functions to get the
 * plugin running.
 */
public interface IService {

    void initService();

    void closeService();

}
